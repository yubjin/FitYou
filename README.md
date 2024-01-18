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
- [상세 설명](#상세-설명)
  * [1. 데이터 크롤링/전처리](#1-데이터-크롤링전처리)
  * [2. 모델](#2-모델)
  * [3. 프론트엔드 서버](#3-프론트엔드-서버)
  * [4. 백엔드 서버](#4-백엔드-서버)


## ⚙ 기술스택

### ✔️Data
<img src="https://img.shields.io/badge/PYTORCH-EE4C2C?style=for-the-badge&logo=PYTORCH&logoColor=white"> <img src="https://img.shields.io/badge/PYTHON-3776AB?style=for-the-badge&logo=PYTHON&logoColor=white"> 

### ✔️Frond-end
<img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white"> <img src="https://img.shields.io/badge/JAVASCRIPT-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white"> 

### ✔️Back-end
<img src="https://img.shields.io/badge/Spring-6DB31F?style=for-the-badge&logo=Spring&logoColor=white"> <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white"> <img src="https://img.shields.io/badge/Springsecurity-6DB39F?style=for-the-badge&logo=Springsecurity&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> <img src="https://img.shields.io/badge/ApacheMaven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"> <img src="https://img.shields.io/badge/postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white">

## 📆 프로젝트 개요

- ##### 진행 기간 : 2023.12.13 ~ 2024.01.19

- ##### 목표 

  - ##### 유저 구매내역 기반의 개인 맞춤 옷 추천 서비스를 개발합니다.

  - ##### 판매량이 높은 제품을 추천하는 서비스를 제공합니다.

- ##### ✏️기획서

  - ##### [기능명세서](https://docs.google.com/spreadsheets/)

  - ##### [ERD](https://www.erdcloud.com/d/m3jB4qgwE4JLzMGZS)

- ##### 와이어프레임

  - ##### [와이어프레임 확인](https://www.figma.com/)

- #### **[팀 노션](https://curly-moonflower-931.notion.site/FitYou-b9ab5107e7914e0399f1e59c1edd2ef4)**




## 📣 프로젝트 소개

##### 코로나 19 바이러스로 인한 언컨택트 시대를 맞이하여 많은 소비자들이 온라인 쇼핑몰을 이용하여 옷을 구매하고 있습니다.

##### 하지만, 본인에게 어울리는 옷을 찾는 데에 어려움을 겪는 사람들은 쇼핑몰에서 원하는 취향을 찾지 못한 채로 계속되는 인터넷 쇼핑에 피로를 느끼는 경우가 많고, 옷이 취향에 맞지 않아 반품을 하거나 중고거래를 이용하여 불필요한 소비가 빈번하게 발생하고 있습니다.

##### 이와 같이 자신에게 어울리는 옷을 찾는 데 어려움을 겪고 있는 사람들을 위해 저희는 빅데이터 및 머신러닝 기반의 맞춤형 패션 추천 웹 플랫폼인 FitYou를 개발하였습니다.

##### FitYou의 이용자들은

##### 1. 개인의 나이, 고객번호 등의 개인정보로 개인 맞춤 의류를 추천받을 수 있습니다.

##### 2. 개인의 선호 스타일 등의 개인정보로 취향 맞춤 의류를 추천받을 수 있습니다.

##### 또한, 옷 상세 정보를 조회하는 기능을 통해 사용자들이 옷을 구매하는데 많은 도움을 제공하고 있습니다. 



## 📣 주요 기능

#### 소셜 로그인을 통해 간편하게 서비스 이용 가능

> Google, Kakao 소셜 로그인을 이용하여, 간단한 신체정보 입력만으로 SSAFit을 이용할 수 있습니다.
>
> 회원정보는 JWT Token, Access Token으로 관리되고 있습니다.



#### 개인 취향 맞춤 추천 서비스

> 개인의 취향에 맞는 옷을 추천합니다.


- 개인 별 선호하는 스타일, 카테고리 별로 옷을 추천하는 기능을 제공합니다.


- **옷 디테일 페이지**

  - 디테일 페이지에서 해당 옷이 언제 가장 많이 구매되었고, 유저들의 리뷰를 확인할 수 있습니다.
  - 또한, 해당 옷의 부가적인 정보(가격, 카테고리)를 제공합니다.




## 📣 서비스 아키텍쳐



## 📣 적용한 빅데이터 기술 사항. 
- k-fashion data set





## ⚙ 설치 및 실행 방법

#### 서비스 아키텍쳐 구조 및 실행 방법



#### FrontEnd(React)

```bash
npm install --global yarn
cd frontend
npm i
yarn start(or npm start)
```



#### BackEnd(SpringBoot)

```shell
cd backend/backend-java
./gradlew build -Pprofile=prod
◦sudo java -jar -Dspring.profiles.active=prod [생성된 JAR 파일명].jar
```



#### Data(Pytorch)

```bash
pip install fastapi

```





## 📣 최종산출물

##### 최종 발표 자료

- PPT
  - [최종 발표 PPT]

  
  
- 홈페이지
  
  - https://localhost:3000
