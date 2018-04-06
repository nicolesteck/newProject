package edu.matc.rest;

import com.reneegrittner.entity.Composition;
import com.reneegrittner.entity.CompositionInstrument;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/services")



public class RestDriver extends Application {

    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(GetConnections.class );
        

        return h;
    }

}


