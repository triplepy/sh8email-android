package org.triplepy.sh8email.sh8.di.component;

import org.triplepy.sh8email.sh8.activities.MainActivity;
import org.triplepy.sh8email.sh8.di.module.ClientModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.di.component
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

@Singleton
@Component(modules = ClientModule.class)
public interface ClientComponent {
    void inject(MainActivity activity);
}
