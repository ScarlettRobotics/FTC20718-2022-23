package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;


/** TankDrive 2 Player
 *  Designed for driving to be on controller 1, upper systems on controller 2.
 *  Tank drive. left stick controls left motor, right stick controls right motor.
 */
@TeleOp(name="TankDrive2P",group="auto")
public class TankDrive2p extends OpMode {
    // Initialize classes from other files
    DualMotorDrive drive;
    ClawCore claw;
    SlideCore slide;

    // Define classes from other files
    @Override
    public void init() {
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);
        telemetry.addData("DRIVE MODE: ", "TankDrive 2 Player");
        telemetry.addData("STATUS: ", "Initialized");
        telemetry.addData("FTC Team #", "20718");
    }

    @Override
    public void loop() {
        telemetry.update();

        //// DRIVETRAIN
        // Move left/right wheels based on left/right stick movement
        double left = -gamepad1.left_stick_y;
        double right = gamepad1.right_stick_y;
        drive.setPowers(left, right);
        // Debug info
        telemetry.addData("Left Wheel", left);
        telemetry.addData("Right Wheel", -right);

        //// CLAW
        // Open/close claw if A/B is pressed (respectively)
        if (gamepad2.a){
            claw.clawOpen();
        } else if(gamepad2.b) {
            claw.clawClose();
        }
        // Debug info
        claw.telemetry(telemetry);

        //// SLIDE
        // Move slide based on LT/RT pressees
        double slidePower = (-gamepad2.left_trigger + gamepad2.right_trigger);
        slide.setSlidePower(slidePower);
        // Debug info
        telemetry.addData("Slide Power",slidePower);

    }
}
