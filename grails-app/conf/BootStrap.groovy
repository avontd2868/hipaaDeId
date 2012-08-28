import DeID.JniDeID
import mcw.edu.crdw.*
class BootStrap {

    def init = { servletContext ->
        
        JniDeID deid = new JniDeID();
        JniDeID.loadDeidLibrary();
        deid.setDictionaryLocation("C:/progra~1/DeID");
           
        String configurationFileContents = readFileAsString("C:\\Users\\George Kowalski\\Documents\\NetBeansProjects\\DeIdent\\config\\deid.cfg");
        //String deIdString = deid.createStringDeidentifier(report, configurationFileContents, bufferSize);
        servletContext.setAttribute("configurationFileContents", configurationFileContents) 
        servletContext.setAttribute("deid", deid) 
        String report = DecodeController.getReportFormated("George Kowalski , Dr Fred ")
        String deIdString = deid.createStringDeidentifier(report, configurationFileContents, 1000);
        println "Started with : ${deIdString}" 
    }
    def destroy = {
    }
    private static String readFileAsString(String filePath)  throws java.io.IOException {
        byte[] buffer = new byte[(int) new File(filePath).length()];
        FileInputStream f = new FileInputStream(filePath);
        f.read(buffer);
        return new String(buffer);
    }
}
