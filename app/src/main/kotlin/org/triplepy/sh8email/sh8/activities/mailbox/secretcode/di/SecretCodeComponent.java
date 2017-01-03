package org.triplepy.sh8email.sh8.activities.mailbox.secretcode.di;

import org.triplepy.sh8email.sh8.activities.mailbox.secretcode.SecretCodeActivity;

import dagger.Component;

/**
 * Created by jelly on 1/2/17.
 */

@Component(modules = SecretCodeModule.class)
public interface SecretCodeComponent {
    void inject(SecretCodeActivity activity);
}
