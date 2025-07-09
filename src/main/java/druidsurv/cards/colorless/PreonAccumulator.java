package druidsurv.cards.colorless;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractPowerCostCard;

import static druidsurv.ModFile.makeID;

@AutoAdd.Ignore
public class PreonAccumulator extends AbstractPowerCostCard {
    public final static String ID = makeID("BFG");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public PreonAccumulator() {
        super(ID, 5, CardType.ATTACK, CardRarity.COMMON, CardTarget.SELF, "PreonAccumulator");
        //setBackgroundTexture("druidsurvResources/images/512/monkey_skill.png", "druidsurvResources/images/1024/monkey_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        //addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new EnergizedPower(p, 2), 2, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp()
    {
        upgradeBlock(5);
    }
}