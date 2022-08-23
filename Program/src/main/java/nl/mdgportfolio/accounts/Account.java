package nl.mdgportfolio.accounts;

import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class Account implements IAccount {

    private final UUID uuid;

    public Account(@Nullable UUID uuid) {
        this.uuid = uuid == null? uuid = UUID.randomUUID() : uuid;
    }

    @Override
    public UUID getUniqueId() {
        return uuid;
    }
}
