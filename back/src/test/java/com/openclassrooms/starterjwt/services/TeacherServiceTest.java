package com.openclassrooms.starterjwt.services;
import com.openclassrooms.starterjwt.models.Teacher;
import com.openclassrooms.starterjwt.repository.TeacherRepository;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TeacherServiceTest {

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherService teacherService;

    @Test
    public void getAllTeacherSuccess(){

        //GIVEN

        Teacher teacher1 =Teacher.builder()
                .id(1L)
                .lastName("BALDE")
                .firstName("Abdourahamane")
                .build();

        Teacher teacher2 =Teacher.builder()
                .id(2L)
                .lastName("DIALLO")
                .firstName("Ibrahim")
                .build();

        //WHEN
        given(teacherRepository.findAll())
                .willReturn(List.of(teacher1,teacher2));
        var teacherList = teacherService.findAll();

        //THEN
        assertThat(teacherList).isNotNull();
        assertThat(teacherList.size()).isEqualTo(2);
    }

    @Test
    public void getByIdTeacher_Success(){

        //GIVEN
        Teacher teacher1 =Teacher.builder()
                .id(1L)
                .lastName("BALDE")
                .firstName("Abdourahamane")
                .build();

        Teacher teacher2 =Teacher.builder()
                .id(2L)
                .lastName("DIALLO")
                .firstName("Ibrahim")
                .build();

        //WHEN
        given(teacherRepository.findById(2L))
                .willReturn(Optional.ofNullable(teacher2));
        var teacher = teacherService.findById(2L);

        //THEN
        assertThat(teacher).isNotNull();

    }
}