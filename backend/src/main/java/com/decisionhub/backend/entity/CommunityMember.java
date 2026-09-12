package com.decisionhub.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "community_members",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_community_member",
                columnNames = {"community_id", "user_id"}
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}