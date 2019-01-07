package org.martseniuk.diploma.bar.service;

/**
 * Interface of bar service.
 *
 * @author Roman_Martseniuk
 */
public interface BarService {

    /**
     * Update value.
     *
     * @param fooConfig new value.
     */
    void updateSetting(String fooConfig);

    /**
     * Get value.
     *
     * @return value.
     */
    String getMessage();
}
