package decoder;

public class Context {

	public boolean saved_entropy_valid;
	public int mb_cols;
	public int mb_rows;

	/*
	 * Frame Header + KeyframeHdr Basic information about the frame type and
	 * size
	 */
	public FrameHdr frame_hdr = new FrameHdr();

	/*
	 * Segmentation Header Defines segment parameters of a frame. Parameters
	 * define different loopfilter settings, quantization indices and entropy
	 * probabilities
	 */
	public SegmentHdr segment_hdr = new SegmentHdr();

	/*
	 * Loopfilter Header Defines parameters for the loopfilter. The loopfilter
	 * removes block artifacts and is run at the end of the algorithm
	 */
	public LoopfilterHdr loopfilter_hdr = new LoopfilterHdr();

	/*
	 * Token Header The Token header includes the compressed idct coefficients
	 */
	public TokenHdr token_hdr = new TokenHdr();
	public TokenDecoder[] tokens = new TokenDecoder[Constants.MAX_PARTITIONS];

	/*
	 * Quant Header The quantization header defines quantization parameters
	 */
	public QuantHdr quant_hdr = new QuantHdr();

	/*
	 * Reference Header The reference header includes information about the
	 * reference frames that may be used in interframes.(non-keyframes)
	 */
	public ReferenceHdr reference_hdr = new ReferenceHdr();

	public DequantFactors dequant_factors[];

	/*
	 * Entropy Header
	 */
	public EntropyHdr entropy_hdr = new EntropyHdr();
	public EntropyHdr saved_entropy = new EntropyHdr();

	public MbInfo[] mb_info_storage;

	public int[] above_token_entropy_ctx;

	Image[] frame_strg = new Image[Constants.NUM_REF_FRAMES];
	public Image[] ref_frames = new Image[Constants.NUM_REF_FRAMES];
	public int[][] subpixel_filters;

}
