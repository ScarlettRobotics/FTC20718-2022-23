package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;


/** TankDrive
 *  Tank drive. left stick controls left motor, right stick controls right motor.
 */
@TeleOp(name="TankDrive",group="auto")
public class TankDrive extends OpMode {
    DualMotorDrive drive;
    ClawCore claw;
    SlideCore slide;

    @Override
    public void init() {                
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);
        telemetry.addData("DRIVE MODE: ", "TankDrive 1 Player");
        telemetry.addData("STATUS: ", "Initialized");
        telemetry.addData("FTC Team #", "20718");
        telemetry.update();
    }

    @Override
    public void loop() {
        telemetry.update();
        //DriveTrain
        double left = -gamepad1.left_stick_y;
        double right = gamepad1.right_stick_y;
        telemetry.addData("Left Stick:", left);
        telemetry.addData("Right Stick:", right);
        drive.setPowers(left, right);

        //Claw
        if (gamepad1.a) {
            claw.clawOpen();
        }

        if (gamepad1.b){
            claw.clawClose();
        }

        //Slide
        double slidePower = (-gamepad1.left_trigger + gamepad1.right_trigger);
        telemetry.addData("Slide Y:",slidePower);

        slide.setSlidePower(slidePower);

        //Claw Debug
        claw.telemetry(telemetry);
    }
}
