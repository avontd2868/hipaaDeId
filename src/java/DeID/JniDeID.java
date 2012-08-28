/**
 * @file JniDeid.java
 * @author Paul Hanbury (University of Pittsburgh, Health Sciences IT)
 *
 * @note The JniDeid class provides a java wrapper for the De-ID library. The
 * native functions are included with the JniDeid.DLL which is included with the
 * De-ID distribution. (If you cannot find this file on your computer, reinstall
 * De-ID making sure that the Java Library option is selected.)
 *
 * JniDeid.DLL is simply a JNI wrapper for the DeID6.DLL. Each function in
 * JniDeid called on of the exposed functions in that library.
 *
 * To use this class make sure that the folder containing the DLL is included in
 * your Windows PATH variable. You also must make sure that its subfolder is
 * included in your CLASSPATH.
 *
 * For example, if you create a class called Foo which uses JniDeid, it can be
 * comiled and run (assuming that De-ID is installed in the default c:\\Program
 * Files\\DeID folder) using the following commands:
 *
 * @code
 * javac -classpath "c:\program files" Foo.java
 * java -classpath ".;c:\program files" Foo
 * @endcode
 *
 * @sa deid_dll.h
 */
package DeID;

import java.lang.*;
import java.io.File;

public class JniDeID {

    /**
     * unLoadDeidLibrary maps the DeID6 library into the applications
     * addressspace via the Windows API function LoadLibrary
     */
    public native static boolean loadDeidLibrary();

    /**
     * createDeidentifier calls the CreateDeidentifier function in DeID6.DLL.
     * The parameters here, correspond to the paramteters in the DLL function.
     *
     * @sa deid_dll.h CreateDeidentifier
     */
    private native void CreateDeidentifier(String inputStr, String outputStr, String configFile);

    private native void CreateDeidentifierEx(String inputStr, String outputStr, String configFile, String dnyLocation);

    private native String CreateStringDeidentifier(String inputStr, String configFile, long resultStringBufferSize);

    private native String CreateStringDeidentifierEx(String inputStr, String configFile, String dnyLocation, long resultStringBufferSize);

    /**
     * unLoadDeidLibrary unmaps the DeID6 library from the applications
     * addressspace via the Windows API function FreeLibrary
     */
    public native static boolean unloadDeidLibrary();

    // Find the location of this (JniDeid.class) file
    private static String getClassFolder() {
        //
        // Find class file name.
        JniDeID dummy = new JniDeID();
        String className = dummy.getClass().getName();
        //
        // Convert to a folder name.
        int last_dot = className.lastIndexOf('.');
        String classFolder;
        if (last_dot >= 0) {
            classFolder = className.substring(0, last_dot);
            classFolder.replace('.', java.io.File.separatorChar);
        } else {
            classFolder = className;
        }
        //
        // Make absolute.
        File file = new File(classFolder);
        classFolder = file.getAbsolutePath();
        //
        return classFolder;
    }

    /**
     * In the static initializer section, we make sure that the JniDeid and the
     * DeID6 libraries will be accessible when called.
     *
     * @pre The libraries are contained in the same folder as the JniDeid class
     * file. This is the defualt setting used by the De-ID setup program.
     */
    static {
        // 
        // make sure that the class directory is in the library path
        String thisPath = getClassFolder();
        String libPath = System.getProperty("java.library.path");
        System.setProperty("java.library.path", thisPath + ";" + libPath);
        //
        // load the library (which should be in the same directory as the class file)
        System.loadLibrary("JniDeID");
    }

    /**
     * Sorry for the capitalization error in previous releases!
     *
     * @sa CreateDeidentifier
     */
    public void createDeidentifier(String inputStr, String outputStr, String configFile) {
        // 
        // If the user specified a dictionary location, we use that.  Otherwise
        // we let De-ID try to guess the correct location.  This could be dangerous in 
        // a Java application, since the Windows API call GetModuleFileName will often 
        // assume that it should use the folder that conatins your "java.exe" file.
        if (dnyFolder_.length() > 0) {
            this.CreateDeidentifierEx(inputStr, outputStr, configFile, dnyFolder_);
        } else {
            this.CreateDeidentifier(inputStr, outputStr, configFile);
        }
    }

    public String createStringDeidentifier(String inputStr, String configFile, int resultStringBufferSize) {
        // 
        // If the user specified a dictionary location, we use that.  Otherwise
        // we let De-ID try to guess the correct location.  This could be dangerous in 
        // a Java application, since the Windows API call GetModuleFileName will often 
        // assume that it should use the folder that conatins your "java.exe" file.
        if (dnyFolder_.length() > 0) {
            return this.CreateStringDeidentifierEx(inputStr, configFile, dnyFolder_, resultStringBufferSize);

        } else {
            return this.CreateStringDeidentifier(inputStr, configFile, resultStringBufferSize);
        }

    }

    /**
     * Saves the location of the deiddata.bin file.
     */
    public void setDictionaryLocation(String folderName) {
        dnyFolder_ = folderName;
    }
    private String dnyFolder_ = new String();
}