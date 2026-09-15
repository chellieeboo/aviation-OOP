DOCUMENTATION

CHOSEN CLASS
CHOSEN MAIN CLASS: Employee
CHILD CLASS: Pilot

Class Diagram
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
            │ + addStaff()                             │
            │ + editStaff()                            │
            │ + staffActions()                        │
            └─────────────────────────────────────────┘
                              │
                              │  has  1 ────── 0..*
                              ▼

            ┌─────────────────────────────────────────┐
            │ Pilot: Properties                       │
            │ - staffName                             │
            │ - designation                           │
            │ - workSchedule                          │
            │ - isClockedIn                           │
            │ - salary                                │
            ├─────────────────────────────────────────┤
            │ Pilot: Methods                          │
            │ + displayInfo()                         │
            │ + timeIn()                              │
            │ + timeOut()                             │
            │ + updateDesignation()                   │
            │ + computeOvertime()                     │
            └─────────────────────────────────────────┘
            Properties: Employee (Main Class)

Data Type	Property	Description	Sample Value
String	employeeName	Full name of the employee or manager	Rochelle Bayogbog
int	employeeId	Unique numeric identifier for the employee	6362
String	department	Department where the employee is assigned	Aviation Operations
String	position	Primary job title	Senior Manager
double	salary	Monthly base compensation in PHP	50000.00

CHILD CLASS: Pilot

Properties: Pilot Class

Data Type	Property	Description	Sample Value
String	staffName	Full name of the aviation staff member	Juan Dela Cruz
String	designation	Specific aviation job role or flight position	Co-pilot
String	workSchedule	Assigned shift or duty hours	Morning
boolean	isClockedIn	Flight/duty attendance status	true
double	salary	Monthly base salary used for overtime computation	32000.00

METHODS: EMPLOYEE

displayInfo(): Displays the personal and employment details of the employee, including ID, Name, Department, Position, and Salary.
displayStaff(): Displays the formatted list of all Pilot members stored in the employee's staffList.
addStaff(): Prompts the user for the details of a new aviation staff member, creates a Pilot object, and adds it to the staffList.
editStaff(): Modifies the information of an existing Pilot record, such as name, work schedule, and salary.
staffActions(): Opens an interactive action sub-menu for a selected Pilot to manage time-in, time-out, designation updates, and overtime calculations.

PILOT CLASS

Methods:

displayInfo(): Displays the complete details of an aviation staff member, including name, designation, work schedule, clock-in status, and salary.
timeIn(): Changes the staff member's attendance status to clocked in if they are not already on duty.
timeOut(): Changes the staff member's attendance status to clocked out if they are currently on duty.
updateDesignation(): Updates the staff member's aviation designation, such as changing from Co-pilot to Pilot.
computeOvertime(): Calculates the staff member's overtime compensation based on their monthly salary and the number of extra duty or flight hours worked.
