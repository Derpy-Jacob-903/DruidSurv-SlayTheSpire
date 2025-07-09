package druidsurv.cards.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.BloontoniumPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class BlockCache extends AbstractEasyCard {
    public final static String ID = makeID("BlockCache");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public BlockCache() {
        super(ID, 0, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF, "BloontoniumCache_CardArt");
        baseBlock = 5;
        exhaust = true;
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new ApplyPowerAction(p, p, new BloontoniumPower(p, 2), 2));
        //block += this.costForTurn*block;
        //blck();
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}