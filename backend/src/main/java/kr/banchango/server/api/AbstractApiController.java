package kr.banchango.server.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public abstract class AbstractApiController {

}
