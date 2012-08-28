package mcw.edu.crdw
import mcw.edu.crdw.domain.*;
import DeID.JniDeID
import grails.converters.JSON
import grails.converters.XML;

class DecodeController {
    static scaffold = Decode
    def serviceList = {
     return    
    
    }
    
    def save = {
        if ( params.message != null ) { 
            String messageToDecode = getReportFormated(params.message);
            Decode dec = new Decode();
            int bufferSize = messageToDecode.length() * 4 
            String configurationFileContents = servletContext.configurationFileContents
            JniDeID deid = servletContext.deid
            //println "CONFIG" <<    configurationFileContents;
            String deIdString = deid.createStringDeidentifier(messageToDecode, configurationFileContents, bufferSize);
            //println "deIdString" <<    deIdString;
            render "<HML>Your DeIdentified message:<br><pre>" << deIdString ;
        } else { 
            return "No Message to De-Identify"
        }
        
        
    }
    // Called on GET or POST
    // Call with GET: /DeIdentApp/decode/message_to_decode
    def decodeAsJSON  = { 
        if ( params.message != null ) { 
            String messageToDecode = getReportFormated(params.message);
            Decode dec = new Decode();
            int bufferSize = messageToDecode.length() * 4 
            String configurationFileContents = servletContext.configurationFileContents
            JniDeID deid = servletContext.deid
            //println "CONFIG" <<    configurationFileContents;
            String deIdString = deid.createStringDeidentifier(messageToDecode, configurationFileContents, bufferSize);
            //println "deIdString" <<    deIdString;
            dec.message = deIdString
            render dec as JSON;
        } else { 
            Decode dec = new Decode();
            dec.message = "You need to specify a message to decode ... "
            render dec as JSON;
        }
    }
    
    def decodeAsXML  = { 
        if ( params.message != null ) { 
            String messageToDecode = getReportFormated(params.message);
            Decode dec = new Decode();
            int bufferSize = messageToDecode.length() * 4 
            String configurationFileContents = servletContext.configurationFileContents
            JniDeID deid = servletContext.deid
            //println "CONFIG" <<    configurationFileContents;
            String deIdString = deid.createStringDeidentifier(messageToDecode, configurationFileContents, bufferSize);
            //println "deIdString" <<    deIdString;
            dec.message = deIdString
            render dec as XML;
        } else { 
            Decode dec = new Decode();
            dec.message = "You need to specify a message to decode ... "
            render dec as XML;
        }
    }
    
    public static  String getReportFormated(String notes) {
        String retString = "";
        if (notes != null) {
            retString += "S_O_H\n";
            retString += "2|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n";
            retString += "E_O_H\n";
            retString += notes + "\nE_O_R";
            //System.out.println retString
            return retString;
        } else {
            return null;
        }
    }
}
