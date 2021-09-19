package com.idus.backend.order;

import com.idus.backend.common.Auditing;
import com.idus.backend.member.Member;

import javax.persistence.*;

@Entity
public class Orders extends Auditing {
    @Id
    @GeneratedValue()
    Long id;

    @Column(nullable = false, length = 100)
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member = null;
}
