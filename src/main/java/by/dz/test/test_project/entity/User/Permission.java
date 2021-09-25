package by.dz.test.test_project.entity.User;

public enum Permission {
    USER("USER"),
    ADMIN("ADMIN");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}
