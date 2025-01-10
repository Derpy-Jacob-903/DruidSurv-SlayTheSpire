package druidsurv.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.cardvars.CardTags;

import static druidsurv.ModFile.makeID;

public class BlockCache extends AbstractEasyCard {
    public final static String ID = makeID("Defend");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public BlockCache() {
        super(ID, 0, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 5;
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        setBackgroundTexture("druidsurvResources/images/512/power_skill.png", "druidsurvResources/images/1024/power_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        block += this.costForTurn*block;
        blck();
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}