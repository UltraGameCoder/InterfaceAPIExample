package nl.mdgportfolio.accounts;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface IAccountSystem {

    /**
     * Retrieves an account by its unique id.
     * @param uuid The unique id of the account
     * @return The account if found. Null otherwise.
     */
    @Nullable IAccount getAccountBy(@NotNull UUID uuid);
}
