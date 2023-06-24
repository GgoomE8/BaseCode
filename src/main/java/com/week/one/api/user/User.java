package com.week.one.api.user;

import com.week.one.api.common.entity.Timestamped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "is_deleted = false")
@SQLDelete(sql = "update users set is_deleted = true where id = ?")
@Entity(name = "users")
public class User extends Timestamped {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    @Column(nullable = false)
    private String username;

    private boolean isDeleted = Boolean.FALSE;
}
