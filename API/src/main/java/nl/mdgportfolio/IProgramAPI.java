package nl.mdgportfolio;

import nl.mdgportfolio.accounts.IAccountSystem;

public interface IProgramAPI {

    /**
     * Gets the system that handles accounts.
     * @return The account system.
     */
    IAccountSystem getAccountSystem();
}
