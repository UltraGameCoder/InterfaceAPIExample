package nl.mdgportfolio;

import nl.mdgportfolio.accounts.AccountSystem;

public class Program implements IProgramAPI {

    private static Program program;

    private final AccountSystem accountSystem;

    private Program() {
        this.accountSystem = new AccountSystem();
    }

    @Override
    public AccountSystem getAccountSystem() {
        return accountSystem;
    }

    /**
     * Gets the instance of the program.
     * @return The instance of the program.
     */
    public static Program getInstance() {
        return Program.program;
    }

    public static void main(String[] args) {
        Program.program = new Program();
    }
}