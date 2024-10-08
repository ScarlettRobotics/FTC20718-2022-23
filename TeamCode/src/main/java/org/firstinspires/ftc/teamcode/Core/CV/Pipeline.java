package org.firstinspires.ftc.teamcode.Core.CV;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

/**
* Pipeline class.
*
* <p>An OpenCV pipeline generated by GRIP.
* Has filters for pink, green, and orange.
* idk what most of this does lol
*
* @author GRIP
*/
public class Pipeline extends OpenCvPipeline {
	//Outputs
	private Mat webcamOutput = new Mat();
	private Mat hsvFilterPink = new Mat();
	private Mat hsvFilterGreen = new Mat();
	private Mat hsvFilterOrange = new Mat();

	/**
	 * This is the primary method that runs the entire pipeline and updates the outputs.
	 */
	public Mat processFrame(Mat source0) {
		// Step CV_flip0:
		Mat cvFlipSrc = source0;
		FlipCode cvFlipFlipcode = FlipCode.BOTH_AXES;
		cvFlip(cvFlipSrc, cvFlipFlipcode, webcamOutput);

		// Step HSV_Threshold0:
		Mat hsvThreshold0Input = webcamOutput;
		double[] hsvThreshold0Hue = {126.25899280575541, 164.641638225256};
		double[] hsvThreshold0Saturation = {119.24460431654677, 255.0};
		double[] hsvThreshold0Value = {94.01978417266187, 255.0};
		hsvThreshold(hsvThreshold0Input, hsvThreshold0Hue, hsvThreshold0Saturation, hsvThreshold0Value, hsvFilterPink);

		// Step HSV_Threshold1:
		Mat hsvThreshold1Input = webcamOutput;
		double[] hsvThreshold1Hue = {51.798561151079134, 78.6348122866894};
		double[] hsvThreshold1Saturation = {80.26079136690646, 159.2662116040956};
		double[] hsvThreshold1Value = {94.01978417266187, 152.73890784982936};
		hsvThreshold(hsvThreshold1Input, hsvThreshold1Hue, hsvThreshold1Saturation, hsvThreshold1Value, hsvFilterGreen);

		// Step HSV_Threshold2:
		Mat hsvThreshold2Input = webcamOutput;
		double[] hsvThreshold2Hue = {12.949640287769784, 40.536166464824376};
		double[] hsvThreshold2Saturation = {148.32591553875542, 235.41808873720134};
		double[] hsvThreshold2Value = {137.58992805755395, 204.95733788395904};
		hsvThreshold(hsvThreshold2Input, hsvThreshold2Hue, hsvThreshold2Saturation, hsvThreshold2Value, hsvFilterOrange);

		return webcamOutput;
	}

	/**
	 * This method is a generated getter for the output of a CV_flip.
	 * @return Mat output from CV_flip.
	 */
	public Mat getWebcamOutput() {
		return webcamOutput;
	}

	/**
	 * This method is a generated getter for the output of a HSV_Threshold.
	 * @return Mat output from HSV_Threshold.
	 */
	public Mat getHsvFilterPink() {
		return hsvFilterPink;
	}

	/**
	 * This method is a generated getter for the output of a HSV_Threshold.
	 * @return Mat output from HSV_Threshold.
	 */
	public Mat getHsvFilterGreen() {
		return hsvFilterGreen;
	}

	/**
	 * This method is a generated getter for the output of a HSV_Threshold.
	 * @return Mat output from HSV_Threshold.
	 */
	public Mat getHsvFilterOrange() {
		return hsvFilterOrange;
	}


	/**
	 * Code used for CV_flip. 
	 * Per OpenCV spec 0 -> flip on X axis.
	 * >0 -> flip on Y axis.
	 * <0 -> flip on both axes.
	 */
	public enum FlipCode {
		X_AXIS(0),
		Y_AXIS(1),
		BOTH_AXES(-1);
		public final int value;
		FlipCode(int value) {
			this.value = value;
		}
	}	
	
	/**
	 * Flips an image along X, Y or both axes.
	 * @param src Image to flip.
	 * @param flipcode FlipCode of which direction to flip.
	 * @param dst flipped version of the Image.
	 */
	private void cvFlip(Mat src, FlipCode flipcode, Mat dst) {
		Core.flip(src, dst, flipcode.value);
	}

	/**
	 * Segment an image based on hue, saturation, and value ranges.
	 *
	 * @param input The image on which to perform the HSL threshold.
	 * @param hue The min and max hue
	 * @param sat The min and max saturation
	 * @param val The min and max value
	 * @param out The image in which to store the output.
	 */
	private void hsvThreshold(Mat input, double[] hue, double[] sat, double[] val,
	    Mat out) {
		Imgproc.cvtColor(input, out, Imgproc.COLOR_BGR2HSV);
		Core.inRange(out, new Scalar(hue[0], sat[0], val[0]),
			new Scalar(hue[1], sat[1], val[1]), out);
	}




}

