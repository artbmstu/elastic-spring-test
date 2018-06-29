package ru.art.vulkan.elasticspring;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StudentRepository extends ElasticsearchRepository<StudentEntity, Integer> {
}
