package druidsurv.actions;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

@Deprecated
public class BloonBlockAction extends GainBlockAction {
    public BloonBlockAction(AbstractCreature target, int amount) {
        super(target, amount);
    }
}
