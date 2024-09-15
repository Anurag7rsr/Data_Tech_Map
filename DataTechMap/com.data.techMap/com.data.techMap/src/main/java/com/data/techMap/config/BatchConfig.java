package com.data.techMap.config;

import com.data.techMap.entity.CollegeData;
import com.data.techMap.repository.CollegeRepo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private static final Logger logger = LoggerFactory.getLogger(BatchConfig.class);

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final CollegeRepo collegeRepo;

    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager, CollegeRepo collegeRepo) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.collegeRepo = collegeRepo;
    }

    @Bean
    public Job importCollegeJob() {
        return new JobBuilder("importCollegeJob", jobRepository)
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .<CollegeData, CollegeData>chunk(10, transactionManager)
                .reader(excelReader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public ItemReader<CollegeData> excelReader() {
        return () -> {
            List<CollegeData> collegeList = new ArrayList<>();
            try (FileInputStream file = new FileInputStream("Data.xlsx")) {  // Adjust path as needed
                Workbook workbook = new XSSFWorkbook(file);
                Sheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet) {
                    if (row.getRowNum() == 0) continue;  // Skip header
                    CollegeData collegeData = new CollegeData();
                    collegeData.setCollegeName(row.getCell(0).getStringCellValue());
                    collegeData.setGendersAccepted(row.getCell(1).getStringCellValue());
                    collegeData.setCampusSize(row.getCell(2).getStringCellValue());
                    collegeData.setTotalStudentEnrollments((int) row.getCell(3).getNumericCellValue());
                    collegeData.setTotalFaculty((int) row.getCell(4).getNumericCellValue());
                    collegeData.setEstablishedYear((int) row.getCell(5).getNumericCellValue());
                    collegeData.setRating((float) row.getCell(6).getNumericCellValue());
                    collegeData.setUniversity(row.getCell(7).getStringCellValue());
                    collegeData.setCourses(row.getCell(8).getStringCellValue());
                    collegeData.setFacilities(row.getCell(9).getStringCellValue());
                    collegeData.setCity(row.getCell(10).getStringCellValue());
                    collegeData.setState(row.getCell(11).getStringCellValue());
                    collegeData.setCountry(row.getCell(12).getStringCellValue());
                    collegeData.setCollegeType(row.getCell(13).getStringCellValue());
                    collegeData.setAverageFees(BigDecimal.valueOf(row.getCell(14).getNumericCellValue()));
                    collegeList.add(collegeData);
                }
            } catch (Exception e) {
                logger.error("Error occurred while reading Excel file: ", e);
            }
            return collegeList.isEmpty() ? null : collegeList.remove(0);
        };
    }

    @Bean
    public ItemProcessor<CollegeData, CollegeData> processor() {
        return collegeData -> {
            // Add any business logic or validation here if necessary
            return collegeData;
        };
    }

    @Bean
    public ItemWriter<CollegeData> writer() {
        return collegeRepo::saveAll;
    }
}
