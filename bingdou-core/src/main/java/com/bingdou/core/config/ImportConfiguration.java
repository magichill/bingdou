package com.bingdou.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by gaoshan on 16-11-1.
 */
@Configuration
@ImportResource(locations={"classpath:beans.xml"})
public class ImportConfiguration {
}
