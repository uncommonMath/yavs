package yavs.model.invite;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import yavs.model.lobby.Lobby;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "invites")
@Getter
@ToString
@NoArgsConstructor
public class Invite {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "invite_id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "lobby_id")
    private Lobby lobby;

    public Invite(Lobby lobby) {
        this.lobby = lobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Invite invite = (Invite) o;
        return id != null && Objects.equals(id, invite.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
