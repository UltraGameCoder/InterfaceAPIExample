package nl.mdgportfolio.accounts;

import java.util.UUID;

public interface IAccount {

    /**
     * Gets the unique id of this account.
     * @return The unique id.
     */
    UUID getUniqueId();
}
