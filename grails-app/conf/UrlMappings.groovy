class UrlMappings {

    static mappings = {
 
        "/decodeMessage/$message"(controller: "decode") {
            action = [GET: "decodeAsJSON", POST: "decodeAsJSON"]
        }
        "/decodeJSON/$message"(controller: "decode") {
            action = [GET: "decodeAsJSON", POST: "decodeAsJSON"]
        }
        "/decodeXML/$message"(controller: "decode") {
            action = [GET: "decodeAsXML", POST: "decodeAsXML"]
        }
	"/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

	"/"{controller = "decode"  
            action = "create"}
        
	"500"(view:'/error')
    }
}
