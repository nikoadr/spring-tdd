package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method(GET())
        url("/cats/Ginger")
    }
    response {
        status(OK())
        headers {
            contentType(applicationJson())
        }
        body([name:"Ginger"])
    }
}
