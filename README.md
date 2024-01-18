# FitYou (핏츄)

#### 빅데이터 기반 개인 맞춤 패션 추천 플랫폼

<!-- ![image-20220404120231497](README.assets/main.png) -->


## 👪 팀원 소개

##### 윤미린

- **빅데이터 분석 및 추천** 
- Github : https://github.com/

##### 박준형

- **프론트 엔드 React 개발** 
- Github : https://github.com/

##### 신유빈

- **서비스 아키텍쳐 설계 및 구현, 백엔드 개발** 
- Github : https://github.com/yubjin

## 목차

- [기술 스택](#⚙-기술스택)
- [프로젝트 개요](#📆-프로젝트-개요)
  * [프로젝트 소개](#📣-프로젝트-소개)
- [서비스 시연](#서비스-시연)
- [디렉토리 구조](#디렉토리-구조)



## ⚙ 기술스택

### ✔️Data
<img src="https://img.shields.io/badge/PYTORCH-EE4C2C?style=for-the-badge&logo=PYTORCH&logoColor=white"> <img src="https://img.shields.io/badge/PYTHON-3776AB?style=for-the-badge&logo=PYTHON&logoColor=white"> 

### ✔️Frond-end
<img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white"> <img src="https://img.shields.io/badge/JAVASCRIPT-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white"> 

### ✔️Back-end
<img src="https://img.shields.io/badge/Spring-6DB31F?style=for-the-badge&logo=Spring&logoColor=white"> <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white"> <img src="https://img.shields.io/badge/Springsecurity-6DB39F?style=for-the-badge&logo=Springsecurity&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> <img src="https://img.shields.io/badge/ApacheMaven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"> <img src="https://img.shields.io/badge/postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white"> <img src="https://img.shields.io/badge/cloudinary-3448C5?style=for-the-badge&logo=cloudinary&logoColor=white">

## 📆 프로젝트 개요

- ##### 진행 기간 : 2023.12.13 ~ 2024.01.19

- ##### 목표 

  - ##### 유저 구매내역 기반의 개인 맞춤 옷 추천 서비스를 개발합니다.

  - ##### 판매량이 높은 제품을 추천하는 서비스를 제공합니다.

- ##### ✏️기획서

  - ##### [기능명세서](https://docs.google.com/spreadsheets/d/1e_Fbd5_JyyXxeHHA7HhxRh6Se_vC8uczQfzZqzjzoEs/edit#gid=0)

  - ##### [ERD](https://www.erdcloud.com/d/m3jB4qgwE4JLzMGZS)

- ##### 와이어프레임

  - ##### [와이어프레임 확인](https://www.figma.com/)

- #### **[팀 노션](https://curly-moonflower-931.notion.site/FitYou-b9ab5107e7914e0399f1e59c1edd2ef4)**




## 📣 프로젝트 소개

##### 변화하는 트렌드에 맞춰, 사람들은 오프라인 매장이나 온라인 쇼핑몰에서 옷을 구매합니다.

##### 하지만, 본인에게 어울리는 옷을 찾는 데에 어려움을 겪는 사람들은 쇼핑몰에서 원하는 취향을 찾지 못한 채로 계속되는 인터넷 쇼핑에 피로를 느끼는 경우가 많고, 오프라인 매장에서는 점원들이 고객들에게 옷을 추천해줄 때 객관적인 지표가 없어 추천에 어려움을 겪는 경우가 생기고 있습니다.

##### 이와 같이 자신에게 어울리는 옷을 찾는 데 어려움을 겪고 있는 사람들과 고객들에게 옷을 추천하는데에 어려움을 겪는 사람들을 위해 저희는 빅데이터 및 머신러닝 기반의 맞춤형 패션 추천 웹 플랫폼인 FitYou를 개발하였습니다.

##### FitYou의 이용자들은

##### 1. 개인의 나이, 고객번호 등의 개인정보로 개인 맞춤 의류를 추천받을 수 있습니다.

##### 2. 개인의 선호 스타일 등의 개인정보로 취향 맞춤 의류를 추천받을 수 있습니다.




## 📣 주요 기능


#### 개인 취향 맞춤 추천 서비스

> 개인의 취향에 맞는 옷을 추천합니다.


- 개인 별 선호하는 스타일, 카테고리 별로 옷을 추천하는 기능을 제공합니다.

- 구매내역을 기반으로 기존에 구매했던 옷들과 유사한 옷들을 추천하는 기능을 제공합니다.




## 📣 적용한 빅데이터 기술 사항. 
- k-fashion data set
- Autoencoder (이용자의 선호 상품과 유사한 상품을 추천해주기 위해 이미지 특징을 추출하는 모델)
- Resnet18 (제품들을 K-fashion data set에 있는 카테고리로 나누기 위해 사용한 모델)
- U2net (오토인코더의 특징 추출을 위해 이미지의 배경을 제거하는 모델)



## 📣 최종산출물

##### 최종 발표 자료

- PPT
  - [최종 발표 PPT](https://docs.google.com/presentation/d/1JtB2IeLISEMlN15uw7cnGCxpZaHZFr2D1PrUT3E3y64/edit#slide=id.g2aff737389a_10_8)

  
  
- 홈페이지
  
  - https://localhost:3000
