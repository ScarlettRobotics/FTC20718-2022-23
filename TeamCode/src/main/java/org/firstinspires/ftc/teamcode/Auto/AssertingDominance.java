package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;

@Autonomous(name = "AssertDominance", group = "Auto")
public class AssertingDominance extends LinearOpMode {
    // Initialize classes from other files
    private DualMotorDrive drive;
    private ClawCore claw;
    private SlideCore slide;

    // Initialize variable for counting time passed from a set instance
    private ElapsedTime runtime = new ElapsedTime();

    // Initialize double variables for each wheel motor
    private double leftMotor = 0;
    private double rightMotor = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("ASSERTING DOMINANCE: ", "ACTIVE");
        telemetry.addData("FTC Team #", "20718");
        telemetry.update();

        // Define classes from other files
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);

        // Continues to the next line when the program is initiated in the controller hub (?)
        waitForStart();

        runtime.reset(); //reset timer
        // Set the slide to fully move up for the duration of the auto period
        //slide.setSlidePower(1);
        wait(2);
        while (opModeIsActive() && (runtime.seconds() <= 20)) {
            // Toggles the claw every 100 ms (open -> closed, or closed -> open)
            claw.clawToggle();
            wait(100);
        }
        // Reset slide power
        //slide.setSlidePower(0);

        telemetry.update();
    }
}

