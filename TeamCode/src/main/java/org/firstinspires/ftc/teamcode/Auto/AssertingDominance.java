package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;

@Autonomous(name = "AssertDominance", group = "Auto")
public class AssertingDominance extends LinearOpMode {

    private DualMotorDrive drive;
    private ClawCore claw;
    private SlideCore slide;
    private ElapsedTime runtime = new ElapsedTime();

    //Vars
    //Motor Speeds
    private double leftMotor = 0;
    private double rightMotor = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("ASSERTING DOMINANCE: ", "ACTIVE");
        telemetry.addData("FTC Team #", "20718");
        telemetry.update();

        //Init
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);

        waitForStart();

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() <= 20)) {
            slide.setSlidePower(1);
            wait(5);
            claw.clawOpen();
            wait(1);
            while(true){
                claw.clawOpen();
                wait(1);
                claw.clawClose();
            }
        }
        telemetry.update();
    }
}

