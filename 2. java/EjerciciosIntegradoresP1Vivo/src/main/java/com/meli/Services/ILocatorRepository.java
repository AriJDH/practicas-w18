package com.meli.Services;

import com.meli.model.Locator;

import java.util.List;

public interface ILocatorRepository<L extends Locator> {
    boolean createLocator(L locator);

    L selectLocator(String id);

    boolean updateLocator(L locator);

    boolean deleteLocator(L locator);

    List<L> getAllLocators();

    double getTotalLocator(String locator);
}
