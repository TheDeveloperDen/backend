package net.developerden.backend.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class DevDenUser {
    @Id
    private long id;
    private long xp;
    private int level;
    private int bumps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DevDenUser that)) return false;
        return id == that.id && xp == that.xp && level == that.level && bumps == that.bumps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, xp, level, bumps);
    }

    public long getId() {
        return id;
    }

    public long getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public int getBumps() {
        return bumps;
    }
}
