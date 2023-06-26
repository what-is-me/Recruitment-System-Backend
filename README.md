---
title: 短学期项目-招聘平台 v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# 短学期项目-招聘平台

> v1.0.0

Base URLs:

* <a href="http://10.100.164.30:9999">正式环境: http://10.100.164.30:9999</a>

# 公司

<a id="opIddoLoginUsingPOST"></a>

## POST doLogin

POST /api/company/doLogin

> Body 请求参数

```json
{
  "uid": "Mary",
  "pwd": "ixnmwgrtuvind"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» uid|body|string| 是 |none|
|» pwd|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "msg": "string",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[SaResult](#schemasaresult)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

<a id="opIdprofileUsingGET"></a>

## GET profile

GET /api/company/profile

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |id|

> 返回示例

> 200 Response

```json
{
  "msg": "string",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[SaResult](#schemasaresult)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

<a id="opIdalterProfileUsingPOST"></a>

## POST alterProfile

POST /api/company/profile

> Body 请求参数

```json
{
  "introduction": "{% mock 'cparagraph' %}",
  "pic": "{% mock 'image' , size='255x255' , background='#66ccff' , foreground='#66ccff' %}",
  "tags": [
    "{% mock 'cword' %}",
    "{% mock 'cword' %}",
    "{% mock 'cword' %}",
    "{% mock 'cword' %}"
  ],
  "address": "{% mock 'county' , true %}",
  "email": "{% mock 'email' %}",
  "tel": "{% mock 'phone' %}",
  "name": "{% mock 'ctitle' %}"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[Company](#schemacompany)| 否 | Company|none|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdsignUpUsingPOST"></a>

## POST signUp

POST /api/company/sign-up

> Body 请求参数

```json
{
  "pwd": "string",
  "uid": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[User](#schemauser)| 否 | User|none|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdsubmittedUsingGET"></a>

## GET submitted

GET /api/company/submitted

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

# 求职者

<a id="opIddoLoginUsingPOST_1"></a>

## POST doLogin

POST /api/employee/doLogin

> Body 请求参数

```json
{
  "pwd": "string",
  "uid": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[User](#schemauser)| 否 | User|none|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdprofileUsingGET_1"></a>

## GET profile

GET /api/employee/profile

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|query|string| 否 ||id|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdalterProfileUsingPOST_1"></a>

## POST alterProfile

POST /api/employee/profile

> Body 请求参数

```json
{
  "address": "string",
  "birthday": "2019-08-24T14:15:22Z",
  "edu": [
    {
      "begin": "2019-08-24T14:15:22Z",
      "detail": "string",
      "end": "2019-08-24T14:15:22Z",
      "major": "string",
      "school": "string"
    }
  ],
  "edu_background": "string",
  "email": "string",
  "name": "string",
  "pic": "string",
  "project_experiences": [
    {
      "begin": "2019-08-24T14:15:22Z",
      "detail": "string",
      "end": "2019-08-24T14:15:22Z",
      "name": "string",
      "role": "string",
      "url": "string"
    }
  ],
  "pwd": "string",
  "self_introduce": "string",
  "sex": "string",
  "star": [
    "string"
  ],
  "tel": "string",
  "uid": "string",
  "want_price": 0,
  "website": "string",
  "work_experiences": [
    {
      "begin": "2019-08-24T14:15:22Z",
      "company": "string",
      "detail": "string",
      "end": "2019-08-24T14:15:22Z",
      "job_name": "string",
      "vocation": "string"
    }
  ]
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[Employee](#schemaemployee)| 否 | Employee|none|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdsignUpUsingPOST_1"></a>

## POST signUp

POST /api/employee/sign-up

> Body 请求参数

```json
{
  "pwd": "password",
  "id": "usst"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[User](#schemauser)| 否 | User|none|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdstarToggleJobUsingGET"></a>

## GET starToggleJob

GET /api/employee/star-toggle

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|jid|query|string| 是 ||jid|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdsubmitUsingPOST"></a>

## POST submit

POST /api/employee/submit

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|jid|query|string| 是 ||jid|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdsubmittedUsingGET_1"></a>

## GET submitted

GET /api/employee/submitted

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

# 职位

<a id="opIdjobUsingGET"></a>

## GET job

GET /api/job

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|jid|query|string| 是 ||jid|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdjobsUsingGET"></a>

## GET jobs

GET /api/jobs

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdjobsSelectedUsingPOST"></a>

## POST jobsSelected

POST /api/jobs

> Body 请求参数

```json
{
  "edu": "博士"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdsaveJobUsingPOST"></a>

## POST saveJob

POST /api/save-job

> Body 请求参数

```json
"{\r\n    \"tags\": [\r\n        \"{% mock 'cword' %}\",\r\n        \"{% mock 'cword' %}\"\r\n    ],\r\n    \"description\": \"{% mock 'cparagraph' %}\",\r\n    \"price_min\": {% mock 'integer' , 8000 , 80000 %},\r\n    \"edu_background\": \"{{'不限'}}\",\r\n    \"price_max\": {% mock 'integer' , 15000 , 150000 %},\r\n    \"address\": \"{% mock 'county' , true %}\",\r\n    \"name\": \"{% mock 'ctitle' %}\"\r\n}"
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[Job](#schemajob)| 否 | Job|none|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIddeleteJobUsingDELETE"></a>

## DELETE deleteJob

DELETE /api/delete-job

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|jid|query|string| 是 ||jid|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|204|[No Content](https://tools.ietf.org/html/rfc7231#section-6.3.5)|No Content|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

# 发帖

<a id="opIdfindAllUsingGET"></a>

## GET findAll

GET /api/passage/all

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

<a id="opIdnewPassageUsingPOST"></a>

## POST newPassage

POST /api/passage/new

> Body 请求参数

```json
{
  "detail": "string",
  "employee": {
    "address": "string",
    "birthday": "2019-08-24T14:15:22Z",
    "edu": [
      {
        "begin": "2019-08-24T14:15:22Z",
        "detail": "string",
        "end": "2019-08-24T14:15:22Z",
        "major": "string",
        "school": "string"
      }
    ],
    "edu_background": "string",
    "email": "string",
    "name": "string",
    "pic": "string",
    "project_experiences": [
      {
        "begin": "2019-08-24T14:15:22Z",
        "detail": "string",
        "end": "2019-08-24T14:15:22Z",
        "name": "string",
        "role": "string",
        "url": "string"
      }
    ],
    "pwd": "string",
    "self_introduce": "string",
    "sex": "string",
    "star": [
      "string"
    ],
    "tel": "string",
    "uid": "string",
    "want_price": 0,
    "website": "string",
    "work_experiences": [
      {
        "begin": "2019-08-24T14:15:22Z",
        "company": "string",
        "detail": "string",
        "end": "2019-08-24T14:15:22Z",
        "job_name": "string",
        "vocation": "string"
      }
    ]
  },
  "pid": "string",
  "replies": [
    "string"
  ],
  "timespan": "2019-08-24T14:15:22Z",
  "title": "string",
  "uid": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|replyId|query|string| 否 ||replyId|
|body|body|[Passage](#schemapassage)| 否 | Passage|none|

> 返回示例

> 200 Response

```json
{
  "property1": {},
  "property2": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» **additionalProperties**|object|false|none||none|

## GET getPassage

GET /api/passage/{pid}

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|pid|path|string| 是 ||none|

> 返回示例

> 200 Response

```json
{
  "msg": "string",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[SaResult](#schemasaresult)|

# 数据模型

<h2 id="tocS_Passage">Passage</h2>

<a id="schemapassage"></a>
<a id="schema_Passage"></a>
<a id="tocSpassage"></a>
<a id="tocspassage"></a>

```json
{
  "detail": "string",
  "employee": {
    "address": "string",
    "birthday": "2019-08-24T14:15:22Z",
    "edu": [
      {
        "begin": "2019-08-24T14:15:22Z",
        "detail": "string",
        "end": "2019-08-24T14:15:22Z",
        "major": "string",
        "school": "string"
      }
    ],
    "edu_background": "string",
    "email": "string",
    "name": "string",
    "pic": "string",
    "project_experiences": [
      {
        "begin": "2019-08-24T14:15:22Z",
        "detail": "string",
        "end": "2019-08-24T14:15:22Z",
        "name": "string",
        "role": "string",
        "url": "string"
      }
    ],
    "pwd": "string",
    "self_introduce": "string",
    "sex": "string",
    "star": [
      "string"
    ],
    "tel": "string",
    "uid": "string",
    "want_price": 0,
    "website": "string",
    "work_experiences": [
      {
        "begin": "2019-08-24T14:15:22Z",
        "company": "string",
        "detail": "string",
        "end": "2019-08-24T14:15:22Z",
        "job_name": "string",
        "vocation": "string"
      }
    ]
  },
  "pid": "string",
  "replies": [
    "string"
  ],
  "timespan": "2019-08-24T14:15:22Z",
  "title": "string",
  "uid": "string"
}

```

Passage

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|detail|string|false|none||none|
|employee|[Employee](#schemaemployee)|false|none||none|
|pid|string|false|none||none|
|replies|[string]|false|none||none|
|timespan|string(date-time)|false|none||none|
|title|string|false|none||none|
|uid|string|false|none||none|

<h2 id="tocS_Employee">Employee</h2>

<a id="schemaemployee"></a>
<a id="schema_Employee"></a>
<a id="tocSemployee"></a>
<a id="tocsemployee"></a>

```json
{
  "address": "string",
  "birthday": "2019-08-24T14:15:22Z",
  "edu": [
    {
      "begin": "2019-08-24T14:15:22Z",
      "detail": "string",
      "end": "2019-08-24T14:15:22Z",
      "major": "string",
      "school": "string"
    }
  ],
  "edu_background": "string",
  "email": "string",
  "name": "string",
  "pic": "string",
  "project_experiences": [
    {
      "begin": "2019-08-24T14:15:22Z",
      "detail": "string",
      "end": "2019-08-24T14:15:22Z",
      "name": "string",
      "role": "string",
      "url": "string"
    }
  ],
  "pwd": "string",
  "self_introduce": "string",
  "sex": "string",
  "star": [
    "string"
  ],
  "tel": "string",
  "uid": "string",
  "want_price": 0,
  "website": "string",
  "work_experiences": [
    {
      "begin": "2019-08-24T14:15:22Z",
      "company": "string",
      "detail": "string",
      "end": "2019-08-24T14:15:22Z",
      "job_name": "string",
      "vocation": "string"
    }
  ]
}

```

Employee

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|address|string|false|none||none|
|birthday|string(date-time)|false|none||none|
|edu|[[EducationExperience](#schemaeducationexperience)]|false|none||none|
|edu_background|string|false|none||none|
|email|string|false|none||none|
|name|string|false|none||none|
|pic|string|false|none||none|
|project_experiences|[[ProjectExperience](#schemaprojectexperience)]|false|none||none|
|pwd|string|false|none||none|
|self_introduce|string|false|none||none|
|sex|string|false|none||none|
|star|[string]|false|none||none|
|tel|string|false|none||none|
|uid|string|false|none||none|
|want_price|number(double)|false|none||none|
|website|string|false|none||none|
|work_experiences|[[WorkExperience](#schemaworkexperience)]|false|none||none|

<h2 id="tocS_WorkExperience">WorkExperience</h2>

<a id="schemaworkexperience"></a>
<a id="schema_WorkExperience"></a>
<a id="tocSworkexperience"></a>
<a id="tocsworkexperience"></a>

```json
{
  "begin": "2019-08-24T14:15:22Z",
  "company": "string",
  "detail": "string",
  "end": "2019-08-24T14:15:22Z",
  "job_name": "string",
  "vocation": "string"
}

```

WorkExperience

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|begin|string(date-time)|false|none||none|
|company|string|false|none||none|
|detail|string|false|none||none|
|end|string(date-time)|false|none||none|
|job_name|string|false|none||none|
|vocation|string|false|none||none|

<h2 id="tocS_ProjectExperience">ProjectExperience</h2>

<a id="schemaprojectexperience"></a>
<a id="schema_ProjectExperience"></a>
<a id="tocSprojectexperience"></a>
<a id="tocsprojectexperience"></a>

```json
{
  "begin": "2019-08-24T14:15:22Z",
  "detail": "string",
  "end": "2019-08-24T14:15:22Z",
  "name": "string",
  "role": "string",
  "url": "string"
}

```

ProjectExperience

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|begin|string(date-time)|false|none||none|
|detail|string|false|none||none|
|end|string(date-time)|false|none||none|
|name|string|false|none||none|
|role|string|false|none||none|
|url|string|false|none||none|

<h2 id="tocS_EducationExperience">EducationExperience</h2>

<a id="schemaeducationexperience"></a>
<a id="schema_EducationExperience"></a>
<a id="tocSeducationexperience"></a>
<a id="tocseducationexperience"></a>

```json
{
  "begin": "2019-08-24T14:15:22Z",
  "detail": "string",
  "end": "2019-08-24T14:15:22Z",
  "major": "string",
  "school": "string"
}

```

EducationExperience

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|begin|string(date-time)|false|none||none|
|detail|string|false|none||none|
|end|string(date-time)|false|none||none|
|major|string|false|none||none|
|school|string|false|none||none|

<h2 id="tocS_Job">Job</h2>

<a id="schemajob"></a>
<a id="schema_Job"></a>
<a id="tocSjob"></a>
<a id="tocsjob"></a>

```json
{
  "address": "string",
  "company_id": "string",
  "description": "string",
  "edu_background": "string",
  "jid": "string",
  "name": "string",
  "price_max": 0,
  "price_min": 0,
  "tags": [
    "string"
  ]
}

```

Job

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|address|string|false|none||none|
|company_id|string|false|none||none|
|description|string|false|none||none|
|edu_background|string|false|none||none|
|jid|string|false|none||none|
|name|string|false|none||none|
|price_max|number(double)|false|none||none|
|price_min|number(double)|false|none||none|
|tags|[string]|false|none||none|

<h2 id="tocS_User">User</h2>

<a id="schemauser"></a>
<a id="schema_User"></a>
<a id="tocSuser"></a>
<a id="tocsuser"></a>

```json
{
  "pwd": "string",
  "uid": "string"
}

```

User

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|pwd|string|false|none||none|
|uid|string|false|none||none|

<h2 id="tocS_Company">Company</h2>

<a id="schemacompany"></a>
<a id="schema_Company"></a>
<a id="tocScompany"></a>
<a id="tocscompany"></a>

```json
{
  "address": "string",
  "email": "string",
  "introduction": "string",
  "jobs": [
    "string"
  ],
  "name": "string",
  "pic": "string",
  "pwd": "string",
  "tags": [
    "string"
  ],
  "tel": "string",
  "uid": "string"
}

```

Company

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|address|string|false|none||none|
|email|string|false|none||none|
|introduction|string|false|none||none|
|jobs|[string]|false|none||none|
|name|string|false|none||none|
|pic|string|false|none||none|
|pwd|string|false|none||none|
|tags|[string]|false|none||none|
|tel|string|false|none||none|
|uid|string|false|none||none|

<h2 id="tocS_SaResult">SaResult</h2>

<a id="schemasaresult"></a>
<a id="schema_SaResult"></a>
<a id="tocSsaresult"></a>
<a id="tocssaresult"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": {}
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string|false|none||信息|
|code|integer|true|none||none|
|data|object|false|none||none|

