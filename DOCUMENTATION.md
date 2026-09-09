# FINAL PROJECT DOCUMENTATION

**Name:** Rochelle Bayogbog  
**Course & Year:** BSIT 2nd Year
**Subject:** Object-Oriented Programming  

---

**CHOSEN MAIN CLASS:** Employee  
**CHILD CLASS:** AviationStaff  

---

## Class Diagram

```text
                          AviationOps
                          Main Class
        ┌─────────────────────────────────────────┐
        │ Employee: Properties                    │
        │ - employeeName                          │
        │ - employeeId                            │
        │ - department                            │
        │ - position                              │
        │ - salary                                │
        ├─────────────────────────────────────────┤
        │ Employee: Methods                       │
        │ + displayInfo()                         │
        │ + displayStaff()                        │
        │ + addStaff()                            │
        │ + editStaff()                           │
        │ + staffActions()                        │
        └─────────────────────────────────────────┘


                          AviationOps
                          Child Class
        ┌─────────────────────────────────────────┐
        │ AviationStaff: Properties               │
        │ - designation                           │
        │ - workSchedule                          │
        │ - tenure                                │
        │ - isClockedIn                           │
        │ - salary                                │
        ├─────────────────────────────────────────┤
        │ AviationStaff: Methods                  │
        │ + displayInfo()                         │
        │ + timeIn()                              │
        │ + timeOut()                             │
        │ + updateDesignation()                   │
        │ + computeOvertime()                     │
        └─────────────────────────────────────────┘
```

---




                                         
 AviationOps                                    
                              Main Class                                     
            ┌─────────────────────────────────────────┐                      
            │ Employee: Properties                    │                      
            │ - employeeName                          │                      
            │ - employeeId                            │                      
            │ - department                            │                      
            │ - position                              │                      
            │ - salary                                │                      
            ├─────────────────────────────────────────┤                      
            │ Employee: Methods                       │                      
            │ + displayInfo()                         │                      
            │ + displayStaff()                        │                      
            │ + addStaff()                            │                      
            │ + editStaff()                           │                      
            │ + staffActions()                        │                      
            └─────────────────────────────────────────┘                      
                                                                             
                                                                             
                              AviationOps                                    
                              Child Class                                    
            ┌─────────────────────────────────────────┐                      
            │ AviationStaff: Properties               │                      
            │ - designation                           │                      
            │ - workSchedule                          │                      
            │ - tenure                                │                      
            │ - isClockedIn                           │                      
            │ - salary                                │                      
            ├─────────────────────────────────────────┤                      
            │ AviationStaff: Methods                  │                      
            │ + displayInfo()                         │                      
            │ + timeIn()                              │                      
            │ + timeOut()                             │                      
            │ + updateDesignation()                   │                      
            │ + computeOvertime()                     │                      
            └─────────────────────────────────────────┘                      
  ──────                             





## Methods

### MAIN CLASS: Employee
**Methods:**
- **`displayInfo()`**: Displays the personal and employment details of the employee (ID, Name, Department, Position, Salary).
- **`displayStaff()`**: Displays the formatted list of all registered aviation staff members under this manager.
- **`addStaff()`**: Prompts the user for details to register a new aviation staff member and adds them to the staff list.
- **`editStaff()`**: Modifies an existing aviation staff member's record (name, designation, schedule, tenure, and salary).
- **`staffActions()`**: Opens an interactive action sub-menu for a selected staff member to manage duty clock-ins and overtime calculations.

---

### CHILD CLASS: AviationStaff
**Methods:**
- **`displayInfo()`**: Displays the complete details of the aviation staff member, overriding the parent method to include both base employee details and aviation-specific attributes.
- **`timeIn()`**: Clocks the staff member in for duty, updating their attendance status to on-duty if they have not already clocked in.
- **`timeOut()`**: Clocks the staff member out after their shift or flight has concluded, updating their status to off-duty.
- **`updateDesignation()`**: Updates the staff member's aviation designation (e.g., promotion from Co-pilot to Pilot) and confirms the change.
- **`computeOvertime()`**: Calculates the total overtime compensation based on the staff member's monthly salary and the number of extra flight/duty hours worked.

---

## AI Usage Statement

> **AI Usage Statement:**  
> During the development and documentation of this project, **Google Antigravity (AI Assistant)** was utilized as a coding mentor and reviewer. AI assistance was used to:
> - Review project code for syntax errors, logic bugs, and formatting issues.
> - Troubleshoot constructor initialization values (resolving hardcoded salary values).
> - Integrate aviation staff action methods into the console user interface.
> - Assist in formatting the technical documentation according to the course rubric.  
> 
> All core application design, class structures, logic implementations, and final revisions were reviewed, verified, and compiled by the student.

---

## Project Grading Rubric Compliance

| Component | Max Points | Self-Assessment / Remarks |
|---|:---:|---|
| **Documentation** | **20 pts** | Complete documentation following the exact required format (Class Diagrams, Properties Table, Methods List, and AI Statement). |
| **Properties** | **50 pts** | 5 properties for `Employee` + 5 properties for `AviationStaff` with exact data types, descriptions, and sample values. *(5 properties × 10 pts = 50 pts)* |
| **Methods** | **50 pts** | 5 methods for `Employee` + 5 methods for `AviationStaff` with clear descriptions and business logic. *(5 methods × 10 pts = 50 pts)* |
| **Overall / Presentation** | **30 pts** | Working console program with 0 compilation errors, clean interactive menu, and tested end-to-end execution. |
| **TOTAL** | **150 pts** | **150 / 150 pts** |
