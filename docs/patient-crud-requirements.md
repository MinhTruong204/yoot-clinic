# Patient CRUD Requirements

## 1. Functional Requirements

### FR-01 Create Patient

1. Input fields:

- `fullName` (required, non-blank)
- `birthYear` (required, >= 1900, <= current year)
- `address` (optional, max 255)
- `phoneNumber` (optional)
- `visitDate` (optional) -> defaults to `LocalDate.now()` if omitted.

2. Generate unique patient code using a globally auto-incrementing sequence `001..999`. -> Format:
   `KL{yyMMdd}-{seq}` (e.g. `KL260301-001`).
3. Persist patient and return created resource.

### FR-02 Read Patients

1. Provide `GET /api/patients` with pagination (`page`, `size`) and optional `search`.
2. Provide `GET /api/patients/{id}`.
3. Return consistent page response metadata.

### FR-03 Update Patient

1. Provide `PATCH /api/patients/{id}`.
2. Apply the same data validity rules as create where relevant.
3. Preserve immutable fields (`id`, `patientCode`).

### FR-04 Delete Patient

1. Provide `DELETE /api/patients/{id}`.
2. Implement soft delete with audit metadata.
3. Exclude deleted records from default reads.

## 5. API Contract Summary

1. `POST /api/patients`
2. `GET /api/patients`
3. `GET /api/patients/{id}`
4. `PATCH /api/patients/{id}`
5. `DELETE /api/patients/{id}`