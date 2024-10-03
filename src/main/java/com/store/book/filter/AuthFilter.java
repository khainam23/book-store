package com.store.book.filter;

import com.store.book.config.ICEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ICEndpoint.ALL)
public class AuthFilter {
}
