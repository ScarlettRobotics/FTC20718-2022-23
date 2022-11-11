package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;


/** TankDrive 2 Player
 *  Designed for driving to be on controller 1, upper systems on controller 2.
 *  Tank drive. left stick controls left motor, right stick controls right motor.
 */
@TeleOp
public class TankDrive2p extends OpMode {
    DualMotorDrive drive = new DualMotorDrive();
    ClawCore claw = new ClawCore();


    @Override
    public void init() {
            drive.init(hardwareMap);

    }

    @Override
    public void loop() {
        //DriveTrain
        double left = -gamepad1.left_stick_y;
        double right = gamepad1.right_stick_y;

        telemetry.addData("Left Stick:", left);
        telemetry.addData("Right Stick:", right);

        drive.setPowers(left, right);


        //Claw
        if (gamepad2.a){
            claw.clawToggle();
        }

        //Slide
        //Still to implements
    }
}
