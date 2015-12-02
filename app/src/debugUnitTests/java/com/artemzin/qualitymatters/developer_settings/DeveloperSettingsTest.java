package com.artemzin.qualitymatters.developer_settings;

import android.support.annotation.NonNull;

import com.artemzin.qualitymatters.QualityMattersRobolectricTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;

import static android.content.Context.MODE_PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(QualityMattersRobolectricTestRunner.class)
public class DeveloperSettingsTest {

    @SuppressWarnings("NullableProblems") // Initialized in @Before.
    @NonNull
    private DeveloperSettings developerSettings;

    @Before
    public void beforeEachTest() {
        developerSettings = new DeveloperSettings(RuntimeEnvironment.application.getSharedPreferences("developer_settings", MODE_PRIVATE));
    }

    @Test
    public void isStethoEnabled_shouldReturnFalseByDefault() {
        assertThat(developerSettings.isStethoEnabled()).isFalse();
    }

    @Test
    public void saveIsStethoEnabled_isStethoEnabled() {
        developerSettings.saveIsStethoEnabled(true);
        assertThat(developerSettings.isStethoEnabled()).isTrue();

        developerSettings.saveIsStethoEnabled(false);
        assertThat(developerSettings.isStethoEnabled()).isFalse();
    }
}