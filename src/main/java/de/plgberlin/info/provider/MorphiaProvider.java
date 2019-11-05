package de.plgberlin.info.provider;

import com.google.inject.Inject;
import com.google.inject.Injector;
import de.plgberlin.info.utils.MongoConstants;
import dev.morphia.Morphia;
import org.mongodb.morphia.ext.guice.GuiceExtension;

import javax.xml.ws.Provider;

public class MorphiaProvider implements Provider<Morphia> {

    private Injector injector;

    @Inject
    public MorphiaProvider(Injector injector) {
        this.injector = injector;
    }

    @Override
    public Morphia get() {
        Morphia morphia = new Morphia();

        new GuiceExtension(morphia, this.injector);

        morphia.mapPackage(MongoConstants.AbuseSystem_COMMON_MODEL_PACKAGE);

        return morphia;


    }

    public Morphia invoke(Morphia request) {
        return null;
    }
}
