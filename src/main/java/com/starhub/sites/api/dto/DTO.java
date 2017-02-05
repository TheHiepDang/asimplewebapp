package com.starhub.sites.api.dto;

import java.io.Serializable;
import net.logstash.logback.encoder.org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
/**
 * Created by Hiep Dang on 1/26/2017.
 */
public abstract class DTO implements Serializable {

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, false);
    }
}
