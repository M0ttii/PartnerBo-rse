package de.plgberlin.info;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import de.plgberlin.info.entities.user.Person;
import de.plgberlin.info.provider.MorphiaProvider;
import de.plgberlin.info.repositories.PersonRepository;
import de.plgberlin.info.utils.MongoConfig;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static jdk.nashorn.internal.objects.NativeFunction.bind;

public class PartnerBoerse {

    public static void main(String[] args){
        MongoConfig mongoConfig = new MongoConfig("localhost", 27017, "" , "", "test");
        Injector injector = Guice.createInjector((Module) new MongoConfig(mongoConfig));

        PersonRepository personRepository = injector.getInstance(PersonRepository.class);

        personRepository.erstellePerson("Theo", new Date(), "theo@se.de", (ArrayList) Arrays.asList("Fußball", "Tischtennis"));
        personRepository.hatHobby("Theo", "Fußball");
        personRepository.findeDurchHobby("Tischtennis");
    }




















    private final MongoConfig mongoConfig;

    public PartnerBoerse(MongoConfig MongoConfig) {
        this.mongoConfig = MongoConfig;
    }

    protected void configure() {

        bind(Morphia.class);
        bind(PersonRepository.class);
        //bind(PunishmentRepository.class).annotatedWith(Names.named(AbuseSystemConstants.AbuseSystem_DATASTORE));
    }

    public MongoClient provideMongoClient() {
        ServerAddress serverAddress = new ServerAddress(this.mongoConfig.getDatabaseHost(), this.mongoConfig.getDatabasePort());

        //MongoCredential credential = MongoCredential.createCredential(this.abuseSystemConfig.getDatabaseUser(), this.abuseSystemConfig.getDatabaseName(), this.abuseSystemConfig.getDatabasePassword().toCharArray());

        //MongoClient mongoClient = new MongoClient(serverAddress);
        //return mongoClient;//, Collections.singletonList(credential));
        return null;
    }

    public Datastore provideDatastore(MongoClient mongoClient, Morphia morphia) {
        Datastore datastore = morphia.createDatastore((com.mongodb.MongoClient) mongoClient, this.mongoConfig.getDatabaseName());
        datastore.ensureIndexes();

        return datastore;
    }
}
