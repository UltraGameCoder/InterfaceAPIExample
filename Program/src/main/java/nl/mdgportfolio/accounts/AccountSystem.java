package nl.mdgportfolio.accounts;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * The system that takes care of handling accounts
 */
public class AccountSystem implements IAccountSystem {

    private final TreeMap<UUID, Account> accounts;

    public AccountSystem() {
        this.accounts = new TreeMap<>(UUID::compareTo);
    }

    @Override
    public synchronized @Nullable Account getAccountBy(@NotNull UUID uuid) {
        return accounts.get(uuid);
    }

    /**
     * Loads an existing account from the database.
     * @param uuid The unique id of the account to load
     * @return The newly loaded account if exists. Null otherwise.
     */
    public @NotNull CompletableFuture<Optional<Account>> loadAccount(@NotNull UUID uuid) {
        Account existing = getAccountBy(uuid);
        if (existing != null) {
            return CompletableFuture.completedFuture(Optional.of(existing));
        }
        return CompletableFuture.supplyAsync(() -> {
            //TODO: Load account information from database if exist.
            Account account = new Account(uuid);
            synchronized (this) {
                this.accounts.put(uuid, account);
            }
            return Optional.of(account);
        });
    }

    /**
     * Saves an account.
     * @param account The account to save
     */
    public void saveAccount(@NotNull Account account) {
        //TODO: Save the account to the database.
    }

    /**
     * Unloads an account.
     * @param account The account to unload
     */
    public synchronized void unloadAccount(@NotNull Account account) {
        accounts.remove(account.getUniqueId(), account);
    }

    /**
     * Deletes an account.
     * @param account The account to delete
     */
    public void deleteAccount(@NotNull Account account) {
        //TODO: Delete the account from the database.
        unloadAccount(account);
    }
}
