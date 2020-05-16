interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;
    boolean done = false;

    @Override
    public void execute() {
        entity.setX(entity.getX() + xMovement);
        entity.setY(entity.getY() + yMovement);

        done = true;
    }

    @Override
    public void undo() {
        if (!done) {
            return;
        }

        entity.setX(entity.getX() - xMovement);
        entity.setY(entity.getY() - yMovement);

        done = false;
    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;
    Integer storedAt;

    @Override
    public void execute() {
        for (int i=0; i<entity.getInventoryLength(); i++) {
            if (entity.getInventoryItem(i) == null) {
                entity.setInventoryItem(i, item);

                storedAt = i;

                break;
            }
        }
    }

    @Override
    public void undo() {
        if (storedAt == null) {
            return;
        }

        entity.setInventoryItem(storedAt, null);
    }
}
