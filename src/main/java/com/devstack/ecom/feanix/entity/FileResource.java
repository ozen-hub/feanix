package com.devstack.ecom.feanix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileResource {
    @Column(name = "file_name", columnDefinition = "LONGBLOB")
    private Blob filename;
    @Column(name = "hash", columnDefinition = "LONGBLOB")
    private Blob hash;
    @Column(name = "directory", columnDefinition = "LONGBLOB")
    private Blob directory;
    @Column(name = "resource_url", columnDefinition = "LONGBLOB")
    private Blob resourceUrl;
}
