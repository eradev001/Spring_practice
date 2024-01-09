package com.eradev.boot_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long departmentId;
        private String departmentName;
        private String departmentAddress;
        private String departmentCode;

        /**
         * @return Long return the departmentId
         */
        public Long getDepartmentId() {
                return departmentId;
        }

        /**
         * @param departmentId the departmentId to set
         */
        public void setDepartmentId(Long departmentId) {
                this.departmentId = departmentId;
        }

        /**
         * @return String return the departmentName
         */
        public String getDepartmentName() {
                return departmentName;
        }

        /**
         * @param departmentName the departmentName to set
         */
        public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
        }

        /**
         * @return String return the departmentAddress
         */
        public String getDepartmentAddress() {
                return departmentAddress;
        }

        /**
         * @param departmentAddress the departmentAddress to set
         */
        public void setDepartmentAddress(String departmentAddress) {
                this.departmentAddress = departmentAddress;
        }

        /**
         * @return String return the departmentCode
         */
        public String getDepartmentCode() {
                return departmentCode;
        }

        /**
         * @param departmentCode the departmentCode to set
         */
        public void setDepartmentCode(String departmentCode) {
                this.departmentCode = departmentCode;
        }

}