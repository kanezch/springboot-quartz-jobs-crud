package com.kanezheng.app.sprintbootquartzjobscrud.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(schema = "portal", name = "job")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int status; // 0: waiting or 1 = success
}
