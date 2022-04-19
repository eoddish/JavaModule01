import java.util.*;



public class Transaction {

    public enum TransferCategory {
        DEBITS,
        CREDITS
    }

    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private TransferCategory transferCategory;
    private Integer transferAmount;
    public Transaction next;

    public Transaction(User recipient, User sender, Integer transferAmount) {
        Recipient = recipient;
        Sender = sender;
        if (transferAmount >= 0)
            this.transferCategory = transferCategory.DEBITS;
        else
            this.transferCategory = transferCategory.CREDITS;
        this.transferAmount = transferAmount;
        this.Identifier = UUID.randomUUID();

    }


    public Transaction(UUID identifier) {
        Identifier = identifier;
    }

    public UUID getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(UUID identifier) {
        Identifier = identifier;
    }

    public User getRecipient() {
        return Recipient;
    }

    public void setRecipient(User recipient) {
        Recipient = recipient;
    }

    public User getSender() {
        return Sender;
    }

    public void setSender(User sender) {
        Sender = sender;
    }

    public TransferCategory getTransferCategory() {
        return transferCategory;
    }

    public void setTransferCategory(TransferCategory transferCategory) {
        this.transferCategory = transferCategory;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Integer transferAmount) {
        if ((transferCategory == TransferCategory.DEBITS && transferAmount >= 0) || (transferCategory == TransferCategory.CREDITS && transferAmount < 0)) {
            this.transferAmount = transferAmount;
        }
    }


}

